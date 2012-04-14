# showdate

A simple website written in Noir, ready to be deployed on Tomcat as a WAR file.

## Run on development mode

```bash
lein deps
lein run
```

## To package as a WAR file

```bash
lein clean
lein uberwar
```

Then copy the generated WAR file to Tomcat's webapps folder

## License

Copyright (C) 2011 Denis Fuenzalida

Distributed under the Eclipse Public License, the same as Clojure.

