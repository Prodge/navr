(ns navr.subs
  (:require [re-frame.core :as re-frame]))

(re-frame/reg-sub
 ::name
 (fn [db]
   (:name db)))


(re-frame/reg-sub
 ::active-panel
 (fn [db _]
   (:active-panel db)))


(re-frame/reg-sub
 ::sorted-entries
 (fn [db]
   (map :id (sort-by :sort (vals (:entries db))))))


(re-frame/reg-sub
  ::entry
  (fn [db [_ id]]
    (get-in db [:entries id])))


(re-frame/reg-sub
  ::entry-id-name-pairs
  (fn [db]
    (map #(vec [(:id %) (:name %)]) (sort-by :sort (vals (:entries db))))))
