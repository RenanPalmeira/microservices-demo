# -*- coding: utf8 -*-

from .handler.activity.endpoint import ActivityHandler

url_patterns = [
    (r'/api/activity', ActivityHandler),
]