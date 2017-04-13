# -*- coding: utf8 -*-

from api.core.request import APIHandler

from .models import Activity
from .resource import ActivityResource

class ActivityHandler(APIHandler):
    """
    Hello!
    """
    def get(self):
        activity = Activity.serialize(Activity.find(1))

        return self.write(activity)