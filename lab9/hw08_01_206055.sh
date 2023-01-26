#!/bin/bash

rm -f modified

day=$(date | awk '{print $3}')
month=$(date | awk '{print $2}')
files=$(ls ~)

for file in $files; do
    fileInfo=$(ls -l "$file")
    fileMonth=$(echo "$fileInfo" | awk '{print $7}')
    fileDay=$(echo "$fileInfo" | awk '{print $8}')

    if [ "$fileDay" = "$day" ] && [ "$fileMonth" = "$month" ]; then
        echo "$file" >>modified
    fi
done
