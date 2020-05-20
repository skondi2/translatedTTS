# translatedTTS

This is a Java program that translates user-inputted text into a user-specified language with the Yandex Translate API. The translated result is printed to the console and the speech pronounciation of the translation is outputted as an audio voice with the MaryTTS opensource library. 

More detail about MaryTTS can be found at this link: http://mary.dfki.de/

The Yandex Translating API is implemented as a GET request. More details about the URL for this request and supported language codes can be found at this link: https://tech.yandex.com/translate/doc/dg/concepts/about-docpage/

# Usage
Below is an example output:
```
Enter text to translate: hola
Enter language code of inputted text: es

Please wait... translating...
Translation : hello
Powered by Yandex.Translate

Please wait... Outputting speech..

Process finished with exit code 0
```
