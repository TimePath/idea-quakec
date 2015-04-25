#!/usr/bin/env sh

IDEA_VERSION="14.1"

wget -O idea.tar.gz https://download.jetbrains.com/idea/ideaIC-${IDEA_VERSION}.tar.gz

tar xf idea.tar.gz
ln -sTf `find . -name 'idea-IC*'`/lib idea-libs
