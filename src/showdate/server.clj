(ns showdate.server
  (:require [noir.server :as server]))

(server/load-views "src/showdate/views/")

;;; after loading the views
(def handler (server/gen-handler {:mode :dev
                                  :ns 'showdate.server}))

(defn -main [& m]
  (let [mode (keyword (or (first m) :dev))
        port (Integer. (get (System/getenv) "PORT" "8080"))]
    (server/start port {:mode mode
                        :ns 'showdate})))

