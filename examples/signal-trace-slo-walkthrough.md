# Signal Trace Slo Dock Walkthrough

This walk-through keeps the domain vocabulary close to the data instead of burying it in prose.

| Case | Focus | Score | Lane |
| --- | --- | ---: | --- |
| baseline | span volume | 119 | watch |
| stress | latency skew | 231 | ship |
| edge | signal loss | 162 | ship |
| recovery | incident shape | 146 | ship |
| stale | span volume | 209 | ship |

Start with `stress` and `baseline`. They create the widest contrast in this repository's fixture set, which makes them better review anchors than the middle cases.

`stress` is the optimistic case; use it to make sure the scoring path still rewards strong signal.
