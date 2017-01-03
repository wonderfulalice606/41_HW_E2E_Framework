#!/bin/sh
#  ====================
GITHUB_ACCOUNT=wonderfulalice606
WS_DIR=workspace
DOC=Documents
REPO_NAME=41_HW_E2E_Framework
APP_VERSION=1.1
MAIN_CLASS_1=core.MyHtmlUnit
MAIN_CLASS_2=core.MySelenium
ARGS_01=
# =====================

if ! which java >/dev/null 2>&1 ; then echo Java not installed; return; fi
if ! which mvn >/dev/null 2>&1 ; then echo Maven not installed; return; fi
if ! which git >/dev/null 2>&1 ; then echo Git not installed; return; fi

if [ -d "$HOME/$DOC/$WS_DIR" ] ; then cd ~/$DOC/$WS_DIR; else echo $WS_DIR directory is not exist; return; fi

if [ -d "$HOME/$DOC/$WS_DIR/$REPO_NAME" ]; then rm -rf $HOME/$DOC/$WS_DIR/$REPO_NAME; fi

git clone https://github.com/$GITHUB_ACCOUNT/$REPO_NAME.git
https://github.com/wonderfulalice606/41_HW_E2E_Framework.git	

cd ./$REPO_NAME

echo "Executing Java programm ..."
mvn clean site -Dtest=AllTests -Dbuild.version="1.1"

#java -cp ./target/$REPO_NAME-$APP_VERSION.jar $MAIN_CLASS $ARGS_01


