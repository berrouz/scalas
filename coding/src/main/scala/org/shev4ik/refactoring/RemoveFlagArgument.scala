package org.shev4ik.refactoring

object RemoveFlagArgument {

  object old {
    class Holder {
      var height = 0
      var width  = 0
      def setDimension(name: String, value: Int) = {
        if (name == "height") {
          this.height = value
        }

        if (name == "width") {
          this.width = value
        }
      }
    }
  }
}
