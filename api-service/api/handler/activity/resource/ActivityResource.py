import halogen

class ActivityResource(halogen.Schema):

    # self = halogen.Link(attr=lambda spell: url_for("spell.get" uid=spell['uid']))
    name = halogen.Attr()
    category = halogen.Attr()
    tag = halogen.Attr()