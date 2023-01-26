#!/bin/bash

if [ $# -ne 2 ]; then
    echo "Usage: $0 <dir1> <dir2>"
    exit 1
fi

if [ ! -d "$1" ] || [ ! -d "$2" ]; then
    echo "One of the provided arguments is not a directory"
    exit 1
fi

files=$(ls "$1")
size="0"

for file in $files; do
    if [[ $file =~ ^[a-z]*\.txt$ ]]; then
        fileSize=$(ls -l "$1/$file" | awk '{print $6}')
        size=$((size + fileSize))
        newFile=${file//\.txt/\.moved_txt}
        mv "$1/$file" "$2/$newFile"
    fi
done

echo "$size"
