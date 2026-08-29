# JetBrains Clock Widget — Design

## Overview
A minimal status bar widget for JetBrains IDEs that displays the current time.

## Surface
- **Type**: Status bar widget (`StatusBarWidgetFactory` + `TextPresentation`)
- **Placement**: Right side of the status bar, anchored near the line:column indicator

## Display
- **Format**: `HH:mm`, 24-hour clock
- **No seconds**
- **No date**
- **Timezone**: system local time (not configurable)

## Update behavior
- Repaints once per minute (no second-level ticking)

## Interaction
- None — purely passive display, no click handler, no popup, no settings page

## Styling
- Inherits default status bar text presentation (font/color) — no custom styling

## Non-goals
- No timezone configuration
- No format configuration
- No click interactions or settings UI
- No date display
