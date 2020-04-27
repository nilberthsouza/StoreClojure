(ns store.core
  (:require [io.pedestal.http :as http]
            [clojure.data.json :as json]
            [io.pedestal.http.route :as route])
  (:gen-class))

(defn ok [body]
  {:status 200 :body body})

(defn greeting-for [nm]
  (if (empty? nm)
    "Hello, world\n"
    (json/write-str {:name nm :greeting "Hello"})))


(defn respond-hello [request]
  (let [nm (get-in request [:query-params :name])
        resp (greeting-for nm)]
    (ok resp)))

(defn index [request]
  {:status 200
   :body "Index Page"})

(def routes
  (route/expand-routes
    #{["/greet" :get respond-hello :route-name :greet]
   ["/index" :get index :route-name :index]})
  )


(def service-map 
  {::http/routes routes
   ::http/type   :jetty
   ::http/port   8890})

(defn start []
  (http/start  (http/create-server service-map)))

(defonce server (atom nil))

(defn start-dev []
  (reset! server
          (http/start (http/create-server
                        (assoc service-map
                               ::http/join? false)))))

(defn stop-dev []
  (http/stop @server))

(defn restart []
  (stop-dev)
  (start-dev))


(defn -main
  [& args]
(start)
  )
  
