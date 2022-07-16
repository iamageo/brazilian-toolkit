<h1 align="center">🇧🇷 Brazilian Toolkit 🇧🇷</h1></br>
<p align="center"> 
Utils library for Brazilian specific businesses.
</p>

<p align="center">
  <a href="https://opensource.org/licenses/Apache-2.0"><img alt="License" src="https://img.shields.io/badge/License-Apache%202.0-blue.svg"/></a>
  <a href="https://android-arsenal.com/api?level=21"><img alt="API" src="https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat"/></a>
  <img alt="repo size" src="https://img.shields.io/github/repo-size/iamageo/brazilian-toolkit"/>
  </br>
    <img alt="forks" src="https://img.shields.io/github/forks/iamageo/brazilian-toolkit?style=social"/>
    <img alt="stars" src="https://img.shields.io/github/stars/iamageo/brazilian-toolkit?style=social"/>
</p>

## Including in your project
[![](https://jitpack.io/v/iamageo/brazilian-toolkit.svg)](https://jitpack.io/#iamageo/brazilian-toolkit)

### Gradle
Add below codes to your **root** `build.gradle` file (not your module build.gradle file).
```gradle
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}
```
And add a dependency code to your **module**'s `build.gradle` file.
```gradle
dependencies {
  implementation 'com.github.iamageo:brazilian-toolkit:1.0.0'
}
```

## Methods
| Function | Description | Status |
| :---------------: | :---------------: | :---------------: | 
| isCpf() |  Return true if `CPF` is valid | ✅ | 
| isCnpj() |  Return true if `CNPJ` is valid | ✅ |
| getAllStates() |  Return list of all brazilian states | 🚧 |
| getAllCities() |  Return list of all cities based on state | 🚧 |



## Basic usage for CPF
```kotlin
"12345678911".isCpf()
```

## Basic usage for CNPJ

```kotlin
"12345678911".isCnpj()
```

## How to ignore characters
The characters `.` and `-` are replaced by String (allowing 127,455,799-41, for example), to modify, just use the charactersToIgnore function:
```kotlin
"127,455,799/41".isCpf(charactersToIgnore = listOf(',', '/'))
```

## License
```
Copyright 2022 Geovani Amaral

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
