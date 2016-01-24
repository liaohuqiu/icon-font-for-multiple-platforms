import UIKit

class ViewController: UIViewController {
    
    let fontName:String = "cube-icons"

    override func viewDidLoad() {
        super.viewDidLoad()
        
        var icon = ""
        
        icon += FontIcons.gems_logo() 
        icon += FontIcons.android() 
        icon += FontIcons.heart() 

        self.addIcon(icon)
    }
    
    func addIcon(icon:String) {
        
        let uiTextView:UITextView = UITextView(frame: self.view.frame)
        uiTextView.contentInset = UIEdgeInsetsMake(20, 0, 20, 0)
        self.view.addSubview(uiTextView)
        
        uiTextView.font = UIFont(name: self.fontName, size: 50)
        uiTextView.text = icon
        uiTextView.editable = false
        uiTextView.selectable = false;
        uiTextView.textAlignment = NSTextAlignment.Left;
        uiTextView.textColor = UIColor.redColor()
        uiTextView.backgroundColor = UIColor.whiteColor()
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
}

