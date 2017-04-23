(ns ui.events
    (:require [re-frame.core :as re-frame]
              [ui.db :as db]))

(re-frame/reg-event-db
 :initialize-db
 (fn  [_ _]
   db/default-db))

(re-frame/reg-event-db
 :set-active-panel
 (fn [db [_ active-panel]]
   (assoc db :active-panel active-panel)))

(re-frame/reg-event-db
  :increment-counter
  (fn [db [_ _]]
    (update-in db [:all-counters] inc)))
