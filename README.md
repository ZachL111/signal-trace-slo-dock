# signal-trace-slo-dock

`signal-trace-slo-dock` is a Scala project in observability. Its focus is to package a Scala local lab for slo analysis with seeded input scenarios, deterministic summary checks, and documented operating limits.

## Why It Exists

The point is to make a small domain rule concrete enough that a reader can change it and immediately see what broke.

## Signal Trace Slo Dock Review Notes

For a quick review, compare `latency skew` with `span volume` before reading the middle cases.

## Features

- `fixtures/domain_review.csv` adds cases for span volume and latency skew.
- `metadata/domain-review.json` records the same cases in structured form.
- `config/review-profile.json` captures the read order and the two review questions.
- `examples/signal-trace-slo-walkthrough.md` walks through the case spread.
- The Scala code includes a review path for `latency skew` and `span volume`.
- `docs/field-notes.md` explains the strongest and weakest cases.

## Architecture Notes

The fixture data drives the tests. The code stays thin, while `metadata/domain-review.json` and `config/review-profile.json` explain what each case is meant to protect.

The Scala addition stays small enough to inspect in one sitting.

## Usage

```powershell
powershell -NoProfile -ExecutionPolicy Bypass -File scripts/verify.ps1
```

## Tests

That command is also the regression path. It verifies the domain cases and catches mismatches between the CSV, metadata, and code.

## Limitations And Roadmap

The fixture set is small enough to audit by hand. The next useful expansion is malformed input coverage, not extra surface area.
