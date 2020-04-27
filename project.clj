(defproject store "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [io.pedestal/pedestal.service       "0.5.7"]
                 [org.clojure/data.json              "1.0.0"]
                 [io.pedestal/pedestal.service-tools "0.5.7"] ;; Only needed for ns-watching; WAR tooling
                 [io.pedestal/pedestal.jetty         "0.5.7"]
                 [io.pedestal/pedestal.immutant      "0.5.7"]
                 [io.pedestal/pedestal.tomcat        "0.5.7"]
                 [io.pedestal/pedestal.aws           "0.5.7"] ;; API-Gateway, Lambda, and X-Ray support
                   ]
  :main ^:skip-aot store.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
