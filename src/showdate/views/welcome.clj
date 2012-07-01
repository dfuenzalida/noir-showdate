(ns showdate.views.welcome
  (:require [showdate.views.common :as common]
            [showdate.models.customers :as customers])

  (:use [noir.core]
        [hiccup.core :only [html]]))

;; notar destructuring aqui
(defpartial table-rows [{:keys [id name]}]
  [:tr
   [:td id ][:td name]]
  )

(defpartial show-item [item]
  [:li (str item)])

(defpage "/" []
  (common/layout
   [:h1 {:style "padding: 10px 0px 10px"} "Lista de Clientes"]

   [:div.row
    [:table {:class "table table-bordered table-stripped"}
     (map table-rows (customers/get-customers))]
    ]

   ))
