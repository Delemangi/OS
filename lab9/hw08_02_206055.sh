#!/bin/bash

files=$(ls "$1")

for file in $files; do
    if [[ $file =~ ^[a-z]*\.txt$ ]]; then
        newFile=${file//\.txt/\.moved_txt}
        mv "$1/$file" "$2/$newFile"
    fi
done
