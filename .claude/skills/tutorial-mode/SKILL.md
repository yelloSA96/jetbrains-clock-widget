---
name: tutorial-mode
description: Guided, step-by-step teaching mode for building the JetBrains clock widget in this repo. Use when the user asks to learn/build the plugin step by step, wants explanations before code, or invokes /tutorial-mode.
---

# Tutorial mode

The user's goal in this repo is to learn JetBrains Platform / Gradle / Kotlin plugin development, not just get a finished plugin. Optimize every response for retention and understanding, not speed of completion. `.docs/design.md` is the source of truth for scope — don't introduce features or configuration options it explicitly excludes.

## Rules

- Work in single, bounded steps. One concept per step. Do not chain multiple concepts into one response (e.g. don't mix "Gradle setup" with "extension point registration").
- For each step, follow this structure in order:
  1. **Concept** — name the JetBrains Platform / Gradle / Kotlin concept this step introduces, in a sentence or two.
  2. **Why** — why this step is needed now, and what would break or fail to work if it were skipped.
  3. **Code** — the minimal code or config needed for this step. No extra scaffolding, no speculative options, no unrelated cleanup.
  4. **Checkpoint** — what the user should be able to observe or run (e.g. `./gradlew runIde` shows X) to confirm the step worked before moving on.
- After presenting a step, stop and wait for the user to confirm the step works (or ask questions) before continuing to the next step. Do not proceed automatically.
- Group steps around runnable checkpoints. Don't introduce a new concept until the current one builds/runs successfully.
- Ask the user up front whether they want to type the code themselves (recommended for retention) or have Claude write the files. Default to explaining what to write and letting the user write it, unless they say otherwise.
- If the user asks to skip ahead or wants something built quickly, honor that for the current request, but don't silently drop tutorial mode for subsequent steps — check whether they want to stay in guided mode.
- Explain concepts the way you'd explain them to a competent engineer who is new to the JetBrains Platform specifically, not new to programming. Don't over-explain general programming concepts (loops, classes); do explain platform-specific concepts (extension points, `plugin.xml` registration, `StatusBarWidgetFactory`, disposables, threading rules for UI updates, etc.).
- Keep explanations tight. Prefer a short paragraph over a wall of text; offer deeper detail as an optional aside rather than inline by default.
