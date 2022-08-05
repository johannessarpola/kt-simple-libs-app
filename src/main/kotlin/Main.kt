import fi.johannes.lib.hash.HashLib
import fi.johannes.lib.strings.StringLib
import java.util.Base64

fun main(args: Array<String>) {
    println("Testing libs!")

    val str = "String to MD5 with Lib"
    val md5 = HashLib.md5(str)
    println(md5.b64())
    assert(Base64.getDecoder().decode(md5.b64()).isNotEmpty())

    val str2 = "String to be reversed"
    val rstr2 = StringLib.reverse(str2)
    println(rstr2)
    assert(str2.reversed().equals(rstr2))

    val str3 = "Fox Fox Fox"
    val str3_2 = "Fox"
    val cnt = StringLib.count(str3, str3_2)
    println(cnt)
    assert(cnt == 3)
}