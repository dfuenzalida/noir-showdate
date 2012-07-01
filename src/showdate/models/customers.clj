(ns showdate.models.customers
  (:use [korma.db]
        [korma.core]))

(defdb db (mysql {:db "sample" :user "root" :password "root"}))

(defentity customers
  (table :CUSTOMER)
  (pk :CUSTOMER_ID))

(defn get-customers []
  (select
   customers
   (fields [:CUSTOMER_ID :id] [:NAME :name])
   (where {:name [like "%Comp%"]}))
  )