//
//  FontData.swift
//
//  Created by liaohuqiu on 12/3/15.
//

import Foundation

class FontIcons: NSObject {
    {% for glyph in glyphs %}
    class func {{ glyph.name_no_dash }}() -> String {
        return "\u{{ glyph.unicode_cully_braces_for_swift }}"
    }
    {% endfor %}
}
