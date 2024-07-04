import com.sksamuel.avro4s.{AvroOutputStream, AvroSchema}

import java.io.File

object AvroMain extends App {
  case class Auto(name: String)
  val os = AvroOutputStream.data[Auto].to(new File("pizza.avro")).build()

  println(AvroSchema[BigDecimal])
  os.write(Auto("A"))
  os.flush()
  os.close()


}
