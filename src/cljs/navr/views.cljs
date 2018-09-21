(ns navr.views
  (:require [re-frame.core :as re-frame]
            [navr.subs :as subs]
            [navr.events :as events]
            ))


(defn navigation []
  [:div
   ;[:a {:href "#/"} "go to Home Page"]
   ;[:a {:href "#/about"} "go to About Page"]
   ]
  )


(defn select
  [{:keys [state]
    :as props}]
  [:> js/Select.Async
   (-> props
       (dissoc state)
       (assoc :value @state
              :on-change #(re-frame/dispatch [::events/new (.. % -value)])))])


(defn load-options [input cb]
  (cb nil #js{:options (->> (range 3)
                            (map (fn [item]
                                   {:value item
                                    :label (str item)}))
                            clj->js)
              :complete true}))


(defn entry [id]
  (let [entry (re-frame/subscribe [::subs/entry id])
        entry-id-name-pairs (re-frame/subscribe [::subs/entry-id-name-pairs])]
    [:div.task {:key (:id @entry)}
      [:input.text {:type "text" :value (:name @entry)
                    :on-change #(re-frame/dispatch [::events/entry-name (:id @entry) (.. % -target -value)])}]
      [:input.num {:type "number" :value (:time @entry)
                   :on-change #(re-frame/dispatch [::events/entry-time (:id @entry) (.. % -target -value)])}]

      ; lets just do an edit box here and display the deps as text
      ; Then we should show a modal with checkboxes when they click edit

      [:select.text {:value (or [(:dependency @entry)] [""])
                     :multiple true
                     :on-change #(re-frame/dispatch [::events/entry-dependency (:id @entry) (.. % -target -value)])}
        [:option {:key "" :value ""} "-"]
        (for [[id entry-name] @entry-id-name-pairs]
          [:option {:key id :value id} entry-name])
        ]



      [:select.text {:value (:state @entry)
                     :on-change #(re-frame/dispatch [::events/entry-state (:id @entry) (.. % -target -value)])}
        [:option {:key "-" :value "-"} "-"]
        [:option {:key "in-progress" :value "in-progress"} "In Progress"]
        [:option {:key "complete" :value "complete"} "Complete"]
        [:option {:key "failed" :value "failed"} "Failed"]
        ]
      ]))


(defn home-panel []
  (let [entry-ids (re-frame/subscribe [::subs/sorted-entries])]
    [:div
      [:div.task.header
        [:div.text "Task name"]
        [:div.num "time"]
        [:div.text "Dependency"]
        [:div.text "status"]
        ]
      (for [id @entry-ids]
        [entry id])
     ]))


;; about

(defn about-panel []
  [:div "This is the About Page."
   [:div [:a {:href "#/"} "go to Home Page"]]])


;; main

(defn- panels [panel-name]
  (case panel-name
    :home-panel [home-panel]
    :about-panel [about-panel]
    [:div]))

(defn show-panel [panel-name]
  [panels panel-name])

(defn main-panel []
  (let [active-panel (re-frame/subscribe [::subs/active-panel])]
    [:div
      [navigation]
      [show-panel @active-panel]]))
