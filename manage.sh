#!/bin/bash

set -e

pushd `dirname $0` > /dev/null
SCRIPTPATH=`pwd -P`
popd > /dev/null
SCRIPTFILE=`basename $0`

function exe_cmd() {
    echo $1
    eval $1
}

function usage() {
    echo ""
    echo "${SCRIPTFILE} -[him]"
    echo -e "\t-h               :   this message"
    echo -e "\t-i | insall      :   install"
    echo -e "\t-m | make        :   make icon font"
    echo -e "\t-o | open        :   open sample"
    echo ""
}

function install() {
    install_file='/Applications/Sketch.app/Contents/Resources/sketchtool/install.sh'
    if [ ! -f $install_file ]; then
        echo "Can not find sketchtool install script: " $install_file
        exit;
    fi
    exe_cmd "sudo $install_file"
    exe_cmd "npm install"
}

function make() {
    exe_cmd "npm run make"
}

function open() {
    exe_cmd "npm run open"
}

if [ $# -gt 0 ]; then
    while [ "$1" != "" ]; do
        case $1 in
            -h | --help )       usage;exit
                                ;;
            -i | install )      install;exit
                                ;;
            -m | make )         make;exit
                                ;;
            -o | open )         open;exit
                                ;;
        esac
        usage;exit;
        shift
    done
else
    usage;exit
fi
