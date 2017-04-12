# -*- coding: utf8 -*-

from api.core.request import APIHandler

from .models import Activity
from .resource import ActivityResource

class ActivityHandler(APIHandler):
    """
    Hello!
    """
    def get(self):
        return self.write(
            Activity.serialize(Activity.find(1))
        )