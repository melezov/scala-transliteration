package hr.element.etb.translit

import com.ibm.icu.text.Transliterator
import java.util.regex.Pattern

object SlugURL {
  protected val URLUnsafeChars =
    "[^-._a-z0-9]+"

  private val default =
    new SlugURL(TransliterateRules.latinToASCII, "-")

  def apply(text: String) =
    default(text)
}

case class SlugURL(transRules: String, replacement: String) {
  private val Trans =
    Transliterator.getInstance(transRules)

  private val URLUnsafeReplacePattern =
    "(%s|%s)+" format(SlugURL.URLUnsafeChars, Pattern.quote(replacement)) r

  private val URLUnsafeTrimPattern =
    "^%s|%1$s$" format(SlugURL.URLUnsafeChars) r

  // convert latin letters to ASCII (ex. đ->d)
  protected val transliterate =
    Trans.transliterate(_: String)

  // convert all to lower case
  protected val lowerCase =
    (_: String).toLowerCase

  // trim all URL non-safe characters from the beginning and the end
  protected val trim =
    URLUnsafeTrimPattern.replaceAllIn(_: String, "")

  // replace all URL non-safe characters
  protected val sanitize =
    URLUnsafeReplacePattern.replaceAllIn(_: String, replacement)

  // do all from above
  def apply(text: String) =
    (transliterate andThen lowerCase andThen trim andThen sanitize)(text)
}
