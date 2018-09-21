(ns navr.events
  (:require [clojure.set :refer [difference]]
            [re-frame.core :as re-frame]
            [navr.db :as db]))


(re-frame/reg-event-db
 ::initialize-db
 (fn  [_ _]
   db/default-db))


(re-frame/reg-event-db
 ::set-active-panel
 (fn [db [_ active-panel]]
   (assoc db :active-panel active-panel)))


(re-frame/reg-event-db
 ::entry-dependency
 (fn [db [_ id dep]]
    (println dep)
     (assoc-in db [:entries id :dependencies] dep)))


(re-frame/reg-event-db
 ::entry-name
 (fn [db [_ id new-name]]
   (assoc-in db [:entries id :name] new-name)))


(re-frame/reg-event-db
 ::entry-time
 (fn [db [_ id new-time]]
   (assoc-in db [:entries id :time] new-time)))


(re-frame/reg-event-db
 ::entry-state
 (fn [db [_ id new-state]]
   (assoc-in db [:entries id :state] (keyword new-state))))
