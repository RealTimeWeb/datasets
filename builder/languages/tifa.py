try:
    unicode
except NameError:
    unicode = str

class TifaDefinition(object):
    def __init__(self, data):
        self.result = ""
        self.indent = 1
        self.result += self.walk(data)
        self.result += ""
    
    def walk(self, chunk):
        self.indent += 1
        start = "\n" + "\t"*self.indent
        if isinstance(chunk, dict):
            start+= self.walk_dict(chunk)
        elif isinstance(chunk, list):
            start+= self.walk_list(chunk)
        else:
            start+= self.walk_atomic(chunk)
        self.indent -= 1
        return start
    
    def convert_literal(self, a_literal):
        if isinstance(a_literal, (float, int)):
            return '{{"type": "LiteralNum", "value": {!r}}}'.format(a_literal)
        elif isinstance(a_literal, (str, unicode)):
            return '{{"type": "LiteralStr", "value": {!r}}}'.format(a_literal)
        elif isinstance(a_literal, bool):
            return '{{"type": "LiteralBool", "value": {!r}}}'.format(a_literal)
    
    def walk_dict(self, a_dict):
        complete = '{"type": "DictType", '
        items = list(a_dict.items())
        literals = ', '.join([self.convert_literal(l) for l, value in items])
        values = ', '.join([self.walk(value) for key, value in items])
        complete += '"literals": [{literals}], '.format(literals=literals)
        complete += '"values": [{values}]'.format(values=values)
        complete += '}'
        return complete
    
    def walk_list(self, a_list):
        complete = '{"type": "ListType", '
        complete += '"subtype": '+self.walk(a_list[0])
        complete += '}'
        return complete
    
    def walk_atomic(self, an_atomic):
        if isinstance(an_atomic, (float, int)):
            return '{"type": "NumType"}'
        elif isinstance(an_atomic, (str, unicode)):
            return '{"type": "StrType"}'
        elif isinstance(an_atomic, bool):
            return '{"type": "BoolType"}'
    