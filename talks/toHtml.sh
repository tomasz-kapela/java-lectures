#!/bin/bash

NAME=Lecture4
INFILE=${NAME}.md
OUTFILE=../html/${NAME}.html
OUTFILE2=../html/${NAME}-all.html

# Creating slides
pandoc -t slidy --self-contained --toc --toc-depth=1 ${INFILE} -o ${OUTFILE}
#pandoc -t s5 --self-contained --base-header-level=5  ${INFILE} -o ${OUTFILE2}

# Creating html page with all slides
pandoc --standalone --toc --toc-depth=1  ${INFILE} -o ${OUTFILE2}
