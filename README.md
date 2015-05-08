# IntelliJ QuakeC

## Development

1. `git clone`
2. Import from gradle
3. `./gradlew setup`
4. `./get-idea-libs.sh`
5. [Configure IntelliJ SDK](http://confluence.jetbrains.com/display/IDEADEV/Getting+Started+with+Plugin+Development)
6. Generate [Parser Code](https://github.com/TimePath/idea-quakec/blob/master/src/main/java/com/timepath/quakec/grammar/QC.bnf) with [Grammar-Kit](https://github.com/JetBrains/Grammar-Kit)
7. Generate JFlex Lexer
8. Run JFlex Generator
9. Remove `src/main/resources` from module test source folders
10. Add a plugin run configuration

## Resources

* [Developing Custom Language Plugins for IntelliJ IDEA](https://confluence.jetbrains.com/display/IDEADEV/Developing+Custom+Language+Plugins+for+IntelliJ+IDEA)
