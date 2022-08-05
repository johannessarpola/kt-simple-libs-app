# "App" to use libs from Github Packages

## Download libs from Github Packages m2 repository

1. Create PAT on Github developer settings with packages:read permission and copy the access token.
2. Open ~HOME/.gradle/gradle.properties
3. Add props for `gpr.user` (your username) and `gpr.key` (PAT token)

It will handle the authentication with following part in gradle

```
    maven {
        url = uri("https://maven.pkg.github.com/<USERNAME>/<REPOSITORY>")
        credentials {
            username = project.findProperty("gpr.user") as String? ?: System.getenv("GITHUB_USERNAME")
            password = project.findProperty("gpr.key") as String? ?: System.getenv("GITHUB_TOKEN")
        }
    }
```

Due note that Github Packages don't work with unauthorized access yet so you need to create the PAT.

It will work on GHA with the env

```yaml
    env:
      GITHUB_TOKEN: ${{ secrets.GITHUB_TOKEN }}
      GITHUB_USERNAME: <USERNAME>
```