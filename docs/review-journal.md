# Review Journal

I treated `signal-trace-slo-dock` as a project where the smallest useful behavior should still be inspectable.

The local checks classify each case as `ship`, `watch`, or `hold`. That gives the project a small review vocabulary that matches its observability focus without claiming live deployment or external usage.

## Cases

- `baseline`: `span volume`, score 119, lane `watch`
- `stress`: `latency skew`, score 231, lane `ship`
- `edge`: `signal loss`, score 162, lane `ship`
- `recovery`: `incident shape`, score 146, lane `ship`
- `stale`: `span volume`, score 209, lane `ship`

## Note

The useful failure mode here is a wrong decision on a named case, not a vague style disagreement.
