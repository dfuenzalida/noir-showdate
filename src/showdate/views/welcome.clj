(ns showdate.views.welcome
  (:require [showdate.views.common :as common]
            [showdate.models.customers :as customers]
            [showdate.models.products :as products])

  (:use [noir.core]
        [hiccup.core :only [html]]))

;; note destructuring
(defpartial table-rows
  [{:keys [id name code manufacturer_id manufacturer_name]}]

  ;; row
  [:tr
   [:td id ]
   [:td code]
   [:td name]
   [:td
    [:a {:href (str "manufacturer/" manufacturer_id)} manufacturer_name]]]
  )

;; default page is the list of products
(defpage "/" []
  (common/layout
   [:h1 {:style "padding: 10px 0px 10px"} "Products List"]

   [:div.row
    [:table {:class "table table-bordered table-stripped"}
     [:tr
      [:th :#][:th "Product Name"][:th :Code][:th :Manufacturer]]
     (map table-rows (products/get-products))]
    ]

   ))

(defpage "/manufacturer/:id" {man-id :id}
  (let [man (products/get-manufacturer man-id)]
    (common/layout
     [:h1 "Manufacturer details"]
     [:h2 (:NAME man)]
     [:h3 (:ADDRESSLINE1 man)]
     [:h3 (:ADDRESSLINE2 man)]
     [:h4 "Phone: " (:PHONE man)]
     )))