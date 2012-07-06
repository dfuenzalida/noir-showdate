(ns showdate.models.products
  (:use [korma.core]))

(defentity products)

(defentity manufacturers
  (table :MANUFACTURER)
  (pk :MANUFACTURER_ID)
  (entity-fields [:NAME :name][:CITY :city])
  (has-many products))

(defentity products
  (table :PRODUCT)
  (pk :PRODUCT_ID)
  (entity-fields [:DESCRIPTION :name][:PRODUCT_CODE :code])
  (belongs-to manufacturers {:fk :MANUFACTURER_ID}))


(defn get-products []
  (select products
   (with manufacturers)
   (fields
    [:PRODUCT_ID :id]
    [:MANUFACTURER_ID :manufacturer_id]
    [:MANUFACTURER.NAME :manufacturer_name]
    [:PRODUCT_CODE :code]
    [:DESCRIPTION :name])
  ))