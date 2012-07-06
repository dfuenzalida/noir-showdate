(ns showdate.server
  (:use [korma.db])
  (:require [noir.server :as server]
            [showdate.views.welcome]
            [showdate.views.common]))

;;; load the views as above, detail on link below
;;; https://groups.google.com/forum/#!msg/clj-noir/QNEzGfS8uUQ/9MriuDkdqXAJ
;;; NOT ANYMORE -> ;; (server/load-views "src/showdate/views/")

;;; after loading the views
(def handler (server/gen-handler {:mode :dev
                                  :ns 'showdate.server}))

(defdb db (mysql {:db "sample" :user "root" :password "root"}))

(def init
  (println "*** init here ***")
  )

(defn -main [& m]
  (let [mode (keyword (or (first m) :dev))
        port (Integer. (get (System/getenv) "PORT" "8080"))]
    (server/start port {:mode mode
                        :ns 'showdate})))

