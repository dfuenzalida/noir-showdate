(defproject showdate "0.1.0-SNAPSHOT"
            :description "A webapp with noir and korma"
            :dependencies [[org.clojure/clojure "1.3.0"]
                           [noir "1.2.1"]
                           [korma "0.3.0-beta9"]
                           [mysql/mysql-connector-java "5.1.6"]
                           [log4j "1.2.17"
                            :exclusions [javax.mail/mail
                                         javax.jms/jms
                                         com.sun.jdmk/jmxtools
                                         com.sun.jmx/jmxri]]]
            :plugins [[lein-ring "0.7.1"]]
            :ring {:handler showdate.server/handler}
            :main showdate.server)

