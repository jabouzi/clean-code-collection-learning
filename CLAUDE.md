# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Purpose

This repository is a personal learning workspace — a scratchpad for experimenting with concepts, keeping notes, and building reference material. Content will grow over time as new topics are explored.

## Project Setup

- **IDE**: IntelliJ IDEA (project configured via `Learning.iml` and `.idea/`)
- **Language**: Kotlin (JVM)
- **Build**: IntelliJ's built-in compiler (no Gradle or Maven — uses `KotlinJavaRuntime` library directly)

## Running Code

From IntelliJ: use the Run gutter icon or `Ctrl+Shift+F10` (macOS: `Ctrl+Shift+R`) on any file with a `main()` function.

From the command line (if `kotlinc` is installed):
```bash
kotlinc src/Main.kt -include-runtime -d out.jar && java -jar out.jar
```

## Structure

- `src/` — Kotlin source files. New topics/experiments go here as standalone files or packages.
- `test/` — Test sources (directory defined in `.iml` but not yet populated).
- `resources/` — Resource files (defined in `.iml` but not yet populated).
