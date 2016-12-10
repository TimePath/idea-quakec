# IntelliJ QuakeC

## Development

1. `git clone`
2. Import from gradle
3. Generate [Parser Code](https://github.com/TimePath/idea-quakec/blob/master/src/main/java/com/timepath/quakec/grammar/QC.bnf) with [Grammar-Kit](https://github.com/JetBrains/Grammar-Kit) (Ctrl+Shift+G)
5. Generate JFlex Lexer into `src/gen/com/timepath/quakec/lexer`
6. Run JFlex Generator into `src/gen/com/timepath/quakec/lexer` (Ctrl+Shift+G)
7. Generate Parser Code again
8. Run `gradle runIdea`

## Resources

* [Developing Custom Language Plugins for IntelliJ IDEA](https://confluence.jetbrains.com/display/IDEADEV/Developing+Custom+Language+Plugins+for+IntelliJ+IDEA)
