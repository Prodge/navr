(ns navr.db)

(def default-db
  {:name "re-frame"
   :entries {:1 {:id :1
                 :name "fast"
                 :time 500
                 :sort 1
                 :dependencies nil}
             :2 {:id :2
                 :name "other"
                 :time 50
                 :sort 2
                 :dependencies :1}}
             })
