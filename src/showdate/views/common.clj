(ns showdate.views.common
  (import java.util.Date)
  (:use [noir.core :only [defpartial]]
        [hiccup.page-helpers :only [include-css html5]]))

(defpartial layout [& content]
  (html5
   [:head
    [:title "Sample"]
    (include-css
     "http://twitter.github.com/bootstrap/assets/css/bootstrap.css")
    (include-css
     "http://twitter.github.com/bootstrap/assets/css/bootstrap-responsive.css")]
   [:body
    [:div.container
     [:div content]
     [:hr]
     [:footer.footer
      [:p.pull-right
       [:a {:href "/"} "Home"] " | "    
       [:a {:href "#"} "Top of the page"]]
      [:p (str "Generado: " (Date.))]]
     ]]
   ))
