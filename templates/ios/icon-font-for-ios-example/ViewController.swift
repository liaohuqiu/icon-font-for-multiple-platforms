//
//  ViewController.swift
//  icon-font-for-ios-example
//
//  Created by HuqiuLiao on 12/3/15.
//  Copyright © 2015 HuqiuLiao. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    
    var num = 0;
    var screenWidth:CGFloat = 0;
    
    let fontName:String = "cubeicons-font"
    let width:CGFloat = 50
    let height:CGFloat = 50
    let margin:CGFloat = 20;

    override func viewDidLoad() {
        super.viewDidLoad()
        
        screenWidth = self.view.frame.size.width
        {% for glyph in glyphs %}
        self.addIcon(FontIcons.{{ glyph.name_no_dash }}()){% endfor %}
    }
    
    func addIcon(icon:String) {
        
        let column = floor((screenWidth -  margin) / (width + margin));
        
        let num = CGFloat(self.num);
        let top = (height + margin) * floor(num / column) + margin + 30;
        let left = (width + margin) * (num % column) + margin;
        
        let uiLable:UILabel = UILabel(frame: CGRectMake(left, top, width, height))
        self.view.addSubview(uiLable)
        uiLable.font = UIFont(name: self.fontName, size: height)
        uiLable.text = icon
        uiLable.textAlignment = NSTextAlignment.Center;
        uiLable.textColor = UIColor.redColor()
        uiLable.backgroundColor = UIColor.grayColor()
        
        self.num = self.num + 1;
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
}
