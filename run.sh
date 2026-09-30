#!/usr/bin/env bash
set -e
echo "==================================================="
echo "  Compiling Student Information System..."
echo "==================================================="
mkdir -p out
javac -encoding UTF-8 -d out src/*.java
echo ""
echo "==================================================="
echo "  Running Simulation..."
echo "==================================================="
java -cp out Main
