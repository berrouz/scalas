package org.shev4ik.interview.docker_k8s.level2_intermediate

object DK008_K8sStorage {

  // ---- Domain types ----

  sealed trait AccessMode
  case object ReadWriteOnce extends AccessMode    // RWO - single node read-write
  case object ReadOnlyMany extends AccessMode     // ROX - multi-node read-only
  case object ReadWriteMany extends AccessMode    // RWX - multi-node read-write

  sealed trait ReclaimPolicy
  case object Retain extends ReclaimPolicy
  case object Delete extends ReclaimPolicy
  case object Recycle extends ReclaimPolicy

  sealed trait PVStatus
  case object Available extends PVStatus
  case object Bound extends PVStatus
  case object Released extends PVStatus
  case object Failed extends PVStatus

  case class StorageClass(
    name: String,
    provisioner: String,           // e.g., "kubernetes.io/aws-ebs", "kubernetes.io/gce-pd"
    reclaimPolicy: ReclaimPolicy = Delete,
    allowVolumeExpansion: Boolean = false,
    parameters: Map[String, String] = Map.empty
  )

  case class PersistentVolume(
    name: String,
    capacityGb: Int,
    accessModes: List[AccessMode],
    storageClassName: String,
    reclaimPolicy: ReclaimPolicy = Delete,
    status: PVStatus = Available,
    boundClaimName: Option[String] = None
  )

  case class PersistentVolumeClaim(
    name: String,
    namespace: String = "default",
    requestedCapacityGb: Int,
    accessModes: List[AccessMode],
    storageClassName: String,
    boundVolumeName: Option[String] = None
  )

  case class StatefulSetSpec(
    name: String,
    namespace: String = "default",
    replicas: Int = 1,
    volumeClaimTemplates: List[PersistentVolumeClaim] = Nil,
    serviceName: String = ""
  )

  // ---- Exercise 1 ----
  // TODO: Find PVs that can satisfy a PVC.
  // A PV matches a PVC if:
  // - PV is Available (status)
  // - PV's storageClassName matches PVC's storageClassName
  // - PV's capacity >= PVC's requestedCapacity
  // - PV's accessModes contain ALL of the PVC's required accessModes
  // Return list of matching PV names, sorted by capacity ascending (prefer smallest fit).
  def findMatchingPVs(pvc: PersistentVolumeClaim, pvs: List[PersistentVolume]): List[String] = ???

  // ---- Exercise 2 ----
  // TODO: Bind a PVC to the best matching PV.
  // Use findMatchingPVs to get candidates, then pick the one with smallest capacity.
  // Return updated (PV, PVC) both marked as Bound and referencing each other.
  // If no match found, return None.
  def bindPVCToPV(
    pvc: PersistentVolumeClaim,
    pvs: List[PersistentVolume]
  ): Option[(PersistentVolume, PersistentVolumeClaim)] = ???

  // ---- Exercise 3 ----
  // TODO: Generate PVC names for a StatefulSet.
  // StatefulSets create PVCs using the pattern:
  // "<volumeClaimTemplate.name>-<statefulset.name>-<ordinal>"
  // where ordinal goes from 0 to replicas-1.
  // Return the list of all PVC names that should exist.
  // Example: StatefulSet "mysql" with replicas=3 and template name "data"
  //       => List("data-mysql-0", "data-mysql-1", "data-mysql-2")
  def generateStatefulSetPVCNames(ss: StatefulSetSpec): List[String] = ???

  // ---- Exercise 4 ----
  // TODO: Calculate total storage used and available in the cluster.
  // Return (totalCapacityGb: Int, usedCapacityGb: Int, availableCapacityGb: Int)
  // - totalCapacity = sum of all PV capacities
  // - usedCapacity = sum of capacities of Bound PVs
  // - availableCapacity = sum of capacities of Available PVs
  def storageUtilization(pvs: List[PersistentVolume]): (Int, Int, Int) = ???

  // ---- Exercise 5 ----
  // TODO: Validate a StorageClass configuration. Return list of error strings.
  // Rules:
  // - name must not be empty (error: "StorageClass name is required")
  // - provisioner must not be empty (error: "Provisioner is required")
  // - If provisioner is "kubernetes.io/aws-ebs", must have parameter "type"
  //   (error: "AWS EBS requires 'type' parameter")
  // - If provisioner is "kubernetes.io/gce-pd", must have parameter "type"
  //   (error: "GCE PD requires 'type' parameter")
  // - Recycle reclaim policy is deprecated (warning: "Recycle policy is deprecated, use Delete or Retain")
  def validateStorageClass(sc: StorageClass): List[String] = ???

  // ---- Exercise 6 ----
  // TODO: Simulate PV lifecycle after a PVC is deleted.
  // Given a list of PVs and a deleted PVC name:
  // 1. Find the PV that was bound to this PVC
  // 2. Based on the PV's reclaimPolicy:
  //    - Delete: remove the PV from the list
  //    - Retain: change PV status to Released, keep boundClaimName
  //    - Recycle: change PV status to Available, clear boundClaimName
  // Return the updated list of PVs.
  def handlePVCDeletion(pvs: List[PersistentVolume], deletedPVCName: String): List[PersistentVolume] = ???

  // ---- Exercise 7 ----
  // TODO: Check if volume expansion is possible for a PVC.
  // Given a PVC, its bound PV, and the StorageClass:
  // - StorageClass must have allowVolumeExpansion = true (error: "StorageClass does not allow expansion")
  // - New capacity must be greater than current (error: "New capacity must be greater than current")
  // - PVC must be currently bound (error: "PVC is not bound")
  // Return either Right(updatedPVC with new capacity) or Left(error string).
  def expandVolume(
    pvc: PersistentVolumeClaim,
    newCapacityGb: Int,
    storageClasses: List[StorageClass]
  ): Either[String, PersistentVolumeClaim] = ???

  // ---- Exercise 8 ----
  // TODO: Generate a storage report for a namespace.
  // Return a Map[String, Any] with:
  // - "total_pvcs" -> Int count of PVCs in namespace
  // - "bound_pvcs" -> Int count of bound PVCs (boundVolumeName is Some)
  // - "pending_pvcs" -> Int count of unbound PVCs
  // - "total_requested_gb" -> Int sum of all PVC requested capacities
  // - "total_bound_gb" -> Int sum of capacities of bound PVCs
  // - "storage_classes_used" -> List[String] distinct storage class names used, sorted
  def storageReport(namespace: String, pvcs: List[PersistentVolumeClaim]): Map[String, Any] = ???

  def main(args: Array[String]): Unit = {
    val pvs = List(
      PersistentVolume("pv-1", 10, List(ReadWriteOnce), "standard"),
      PersistentVolume("pv-2", 20, List(ReadWriteOnce, ReadOnlyMany), "standard"),
      PersistentVolume("pv-3", 50, List(ReadWriteMany), "premium"),
      PersistentVolume("pv-4", 10, List(ReadWriteOnce), "standard", status = Bound, boundClaimName = Some("existing-pvc")),
      PersistentVolume("pv-5", 5, List(ReadWriteOnce), "standard")
    )

    // Exercise 1: findMatchingPVs
    val pvc1 = PersistentVolumeClaim("my-pvc", requestedCapacityGb = 8, accessModes = List(ReadWriteOnce), storageClassName = "standard")
    val matches = findMatchingPVs(pvc1, pvs)
    assert(matches == List("pv-1", "pv-2"))  // pv-5 too small, pv-4 bound, pv-3 wrong class
    println("Exercise 1 passed: findMatchingPVs")

    // Exercise 2: bindPVCToPV
    val bindResult = bindPVCToPV(pvc1, pvs)
    assert(bindResult.isDefined)
    val (boundPV, boundPVC) = bindResult.get
    assert(boundPV.name == "pv-1") // smallest fit
    assert(boundPV.status == Bound)
    assert(boundPVC.boundVolumeName.contains("pv-1"))
    println("Exercise 2 passed: bindPVCToPV")

    // Exercise 3: generateStatefulSetPVCNames
    val ss = StatefulSetSpec("mysql", replicas = 3, volumeClaimTemplates = List(
      PersistentVolumeClaim("data", requestedCapacityGb = 10, accessModes = List(ReadWriteOnce), storageClassName = "standard"),
      PersistentVolumeClaim("logs", requestedCapacityGb = 5, accessModes = List(ReadWriteOnce), storageClassName = "standard")
    ))
    val pvcNames = generateStatefulSetPVCNames(ss)
    assert(pvcNames.length == 6)
    assert(pvcNames.contains("data-mysql-0"))
    assert(pvcNames.contains("data-mysql-2"))
    assert(pvcNames.contains("logs-mysql-1"))
    println("Exercise 3 passed: generateStatefulSetPVCNames")

    // Exercise 4: storageUtilization
    val (total, used, avail) = storageUtilization(pvs)
    assert(total == 95)  // 10+20+50+10+5
    assert(used == 10)   // pv-4 is Bound
    assert(avail == 85)  // pv-1+pv-2+pv-3+pv-5
    println("Exercise 4 passed: storageUtilization")

    // Exercise 5: validateStorageClass
    val validSC = StorageClass("standard", "kubernetes.io/aws-ebs", parameters = Map("type" -> "gp2"))
    assert(validateStorageClass(validSC).isEmpty)
    val badSC = StorageClass("", "", Recycle)
    val scErrors = validateStorageClass(badSC)
    assert(scErrors.contains("StorageClass name is required"))
    assert(scErrors.contains("Provisioner is required"))
    assert(scErrors.exists(_.contains("deprecated")))
    println("Exercise 5 passed: validateStorageClass")

    // Exercise 6: handlePVCDeletion
    val retainPV = PersistentVolume("pv-retain", 10, List(ReadWriteOnce), "standard", Retain, Bound, Some("my-pvc"))
    val deletePV = PersistentVolume("pv-delete", 10, List(ReadWriteOnce), "standard", Delete, Bound, Some("other-pvc"))
    val afterDeletion = handlePVCDeletion(List(retainPV, deletePV), "my-pvc")
    assert(afterDeletion.length == 2)
    assert(afterDeletion.find(_.name == "pv-retain").get.status == Released)
    val afterDelete2 = handlePVCDeletion(List(retainPV, deletePV), "other-pvc")
    assert(afterDelete2.length == 1) // pv-delete removed
    println("Exercise 6 passed: handlePVCDeletion")

    // Exercise 7: expandVolume
    val expandSC = StorageClass("expandable", "provisioner", allowVolumeExpansion = true)
    val noExpandSC = StorageClass("fixed", "provisioner", allowVolumeExpansion = false)
    val boundPvc = PersistentVolumeClaim("pvc", requestedCapacityGb = 10, accessModes = List(ReadWriteOnce),
      storageClassName = "expandable", boundVolumeName = Some("pv-1"))
    assert(expandVolume(boundPvc, 20, List(expandSC)).isRight)
    assert(expandVolume(boundPvc, 20, List(expandSC)).map(_.requestedCapacityGb).contains(20))
    assert(expandVolume(boundPvc, 5, List(expandSC)).isLeft)
    val unboundPvc = PersistentVolumeClaim("pvc2", requestedCapacityGb = 10, accessModes = List(ReadWriteOnce), storageClassName = "fixed")
    assert(expandVolume(unboundPvc, 20, List(noExpandSC)).isLeft)
    println("Exercise 7 passed: expandVolume")

    // Exercise 8: storageReport
    val pvcs = List(
      PersistentVolumeClaim("pvc-1", "default", 10, List(ReadWriteOnce), "standard", Some("pv-1")),
      PersistentVolumeClaim("pvc-2", "default", 20, List(ReadWriteOnce), "premium", Some("pv-2")),
      PersistentVolumeClaim("pvc-3", "default", 5, List(ReadWriteOnce), "standard", None),
      PersistentVolumeClaim("pvc-4", "other", 10, List(ReadWriteOnce), "standard", None)
    )
    val report = storageReport("default", pvcs)
    assert(report("total_pvcs") == 3)
    assert(report("bound_pvcs") == 2)
    assert(report("pending_pvcs") == 1)
    assert(report("total_requested_gb") == 35)
    assert(report("total_bound_gb") == 30)
    assert(report("storage_classes_used") == List("premium", "standard"))
    println("Exercise 8 passed: storageReport")

    println("All DK008_K8sStorage exercises passed!")
  }
}
