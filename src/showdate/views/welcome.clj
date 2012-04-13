(ns showdate.views.welcome
  (import java.util.Date)
  (:require [showdate.views.common :as common])

  (:use [noir.core :only [defpage]]
        [hiccup.core :only [html]]))

(defpage "/" []
         (common/layout
          [:h1 (str "La hora: " (Date.))]
          ))
