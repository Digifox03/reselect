# Changelog
All notable changes to Reselect will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]
### Added
- Functions `axolotl_variant`, `cat_type`, `fox_type`, `horse_color`,
`horse_marking`, `mooshroom_type`, `panda_gene`, `parrot_variant`,
`rabbit_variant`, `sheep_color`, `shulker_color`, `tropical_fish_base`,
`tropical_fish_pattern`, and `tropical_fish_variant`.
- Type-class `Collared` and `collar_color` function
- Type-class `Tameable` and `is_tamed` function
### Changed
- Renamed `biome` to `current_biome`
- Renamed `hasname` to `has_name`
- Renamed `isbaby` to `is_baby`
- Comments now begin with double dash (`--`) instead of the hash `#`

## [v0.2.0-alpha.5] - 2022-01-13
### Fixed
- Types of functions `hasname` and `name`.

## [v0.2.0-alpha.4] - 2022-01-13 [YANKED]
### Fixed
- Types of functions `hasname` and `name`.

## [v0.2.0-alpha.3] - 2022-01-12
### Fixed
- Seedable Entity instance generating bad seeds
- Bad registration of functions `y`, `z`, `biome`, `hasname`, and `name`.

## [v0.2.0-alpha.2] - 2022-01-11
### Added
- Support for minecraft version 1.18.

## [v0.2.0-alpha] - 2021-12-03
### Added
- Basic implementation of reselect language.
- Minimal implementation of VMT.
- Functions `contains`, `lowercase`, `matches`,
- Type-class `Random`, and function `rand`.
- Type-class `Seedable`, and function `seed`.
- Type-class `Entity`, and functions `x`, `y`, `z`, `biome`, `hasname`,
`name`.
- Type-class `LivingEntity` and functions `isbaby` and `health`.

[Unreleased]: https://github.com/Digifox03/reselect/compare/v0.2.0-alpha.4...HEAD
[v0.2.0-alpha.5]: https://github.com/Digifox03/reselect/compare/v0.2.0-alpha.4...v0.2.0-alpha.5
[v0.2.0-alpha.4]: https://github.com/Digifox03/reselect/compare/v0.2.0-alpha.3...v0.2.0-alpha.4
[v0.2.0-alpha.3]: https://github.com/Digifox03/reselect/compare/v0.2.0-alpha.2...v0.2.0-alpha.3
[v0.2.0-alpha.2]: https://github.com/Digifox03/reselect/compare/v0.2.0-alpha...v0.2.0-alpha.2
[v0.2.0-alpha]: https://github.com/Digifox03/reselect/releases/tag/v0.2.0-alpha
