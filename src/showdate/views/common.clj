(ns showdate.views.common
  (:use [noir.core :only [defpartial]]
        [hiccup.page-helpers :only [include-css html5]]))

(defpartial layout [& content]
            (html5
              [:head
               [:title "showdate"]
               (include-css "/css/no-reset.css")]
              [:body
               [:div#wrapper
                content]]))
