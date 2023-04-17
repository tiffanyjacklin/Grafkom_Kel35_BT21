#version 330
uniform vec4 uni_color;
out vec4 fragColor;
void main()
{
    //vec4(red,green,blue,alpha)
    //rgba -> red 100/255
//    fragColor = vec4(1.0,1.0,0.0,1.0);
    fragColor = uni_color;
}
