# signal-trace-slo-dock

`signal-trace-slo-dock` is a focused Scala codebase around package a Scala local lab for slo analysis with seeded input scenarios, deterministic summary checks, and documented operating limits. It is meant to be easy to inspect, run, and extend without a hosted service.

## Signal Trace Slo Dock Walkthrough

I would read the project from the outside in: command, fixture, model, then roadmap. That keeps the observability idea grounded in files that can be checked locally.

## Reason For The Project

I use this kind of project to make a rule visible before adding more machinery around it. The important part here is not the size of the codebase. It is that the input signals, scoring rule, fixture data, and expected output can all be checked in one sitting.

## How It Is Put Together

The design is intentionally direct: parse or construct a signal, score it, classify it, and verify the expected branch. This makes the repository useful for studying observability behavior without needing a service or database unless the language project itself is SQL. The Scala code uses case classes and a compact object API to keep the test path direct.

## Data Notes

`examples/extended_cases.csv` adds six named cases. I kept the names plain so failures are easy to read in a terminal: baseline, pressure, surge, degraded, recovery, and boundary.

## Capabilities

- Uses fixture data to keep log shape changes visible in code review.
- Includes extended examples for latency summaries, including `surge` and `degraded`.
- Documents incident slices tradeoffs in `docs/operations.md`.
- Runs locally with a single verification command and no external credentials.
- Stores project constants and verification metadata in `metadata/project.json`.

## Getting It Running

The only required setup is the local Scala toolchain. After cloning, stay in the repo root so fixture paths resolve correctly.

## Check The Work

```powershell
powershell -NoProfile -ExecutionPolicy Bypass -File scripts/audit.ps1
```

The audit command checks repository structure and README constraints before it delegates to the verifier.

## Where Things Live

- `src`: primary implementation
- `tests`: verification harness
- `fixtures`: compact golden scenarios
- `examples`: expanded scenario set
- `metadata`: project constants and verification metadata
- `docs`: operations and extension notes
- `scripts`: local verification and audit commands

## Tradeoffs

The repository favors determinism over breadth. It does not pull live data, keep secrets, or depend on network access for verification.

## Possible Extensions

- Add malformed input fixtures so the failure path is as visible as the happy path.
- Split the scoring constants into a typed configuration object and validate it before use.
- Add a comparison mode that shows how decisions change when one signal is adjusted.
- Add one more observability fixture that focuses on a malformed or borderline input.

## Command Examples

```powershell
powershell -NoProfile -ExecutionPolicy Bypass -File scripts/verify.ps1
```

This runs the language-level build or test path against the compact fixture set.
