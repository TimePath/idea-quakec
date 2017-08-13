{
    pkgs ? import <nixpkgs> {},
}:
let
    inherit (pkgs) stdenv;
    gradleCaches' = stdenv.mkDerivation {
        name = "gradle-caches";
        phases = ["buildPhase"];
        buildPhase = ''
            cp -r ${/home/timepath/.gradle/caches} $out
        '';
    };
    gradleCaches = "false";
    result = stdenv.mkDerivation {
        name = "qcide.zip";
        src = ./src;
        phases = ["buildPhase"];
        nativeBuildInputs = with pkgs; [
            gradleGen.gradle_2_14
        ];
        buildPhase = ''
            export GRADLE_USER_HOME=$PWD/home/.gradle
            mkdir -p $GRADLE_USER_HOME

            # cp -r ${gradleCaches} $GRADLE_USER_HOME/caches
            # chmod -R 777 $GRADLE_USER_HOME

            cp -r $src src

            cp ${./build.gradle} build.gradle
            gradle build

            mv build/distributions/*.zip $out
        '';
    };
in result
