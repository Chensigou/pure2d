#ifndef LWF_PURE2D_BITMAP_H
#define LWF_PURE2D_BITMAP_H

#include "lwf_renderer.h"

namespace LWF {

class Pure2DRendererFactory;

class Pure2DRendererBitmapContext
{
public:
	struct Vector2 {
		float x;
		float y;

		Vector2() {}
		Vector2(float ax, float ay) : x(ax), y(ay) {}
	};

protected:
	int m_textureId;
	int m_glTextureId;
	Vector2 m_vertices[4];
	Vector2 m_coordinates[4];
	unsigned short m_indices[6];
	bool m_preMultipliedAlpha;
	float m_height;

public:
	Pure2DRendererBitmapContext(const Data *data,
		const Format::BitmapEx &bx);
	virtual ~Pure2DRendererBitmapContext();
	bool IsPreMultipliedAlpha() const {return m_preMultipliedAlpha;}
	float GetHeight() const {return m_height;}
	int GetTextureId() const {return m_textureId;}
	int GetGLTextureId() const {return m_glTextureId;}
	void SetGLTexture(int id, float u, float v);
	const Vector2 *GetVertices() const {return m_vertices;}
	const Vector2 *GetCoordinates() const {return m_coordinates;}
	const unsigned short *GetIndices() const {return m_indices;}
};

class Pure2DRendererBitmapRenderer : public Renderer
{
protected:
	Pure2DRendererFactory *m_factory;
	Pure2DRendererBitmapContext *m_context;

public:
	Pure2DRendererBitmapRenderer(
		Pure2DRendererFactory *factory, LWF *l, Bitmap *bitmap);
	Pure2DRendererBitmapRenderer(
		Pure2DRendererFactory *factory, LWF *l, BitmapEx *bitmapEx);

	void Destruct();
	void Update(const Matrix *matrix, const ColorTransform *colorTransform);
	void Render(const Matrix *matrix, const ColorTransform *colorTransform,
		int renderingIndex, int renderingCount, bool visible);
};

}   // namespace LWF

#endif
